local Services={
    Players=game:GetService("Players"),
    ReplicatedStorage=game:GetService("ReplicatedStorage"),
    ServerStorage=game:GetService("ServerStorage"),
    Lighting=game:GetService("Lighting"),
    TeleportService=game:GetService("TeleportService")
};
local InitialRandom=nil;
local randomizer=nil;
local hasStarted=false;
local iteration=0;
local generatedParts={};
local spawnPosition=workspace.Spawn:GetPivot().Position;
Services.Players.PlayerAdded:Connect(function(plr)
    if InitialRandom==nil then
        local joinDat=plr:GetJoinData();
        if joinDat and joinDat.TeleportData then
            InitialRandom=joinDat.TeleportData.InitialRandom or tick(); --seed
        else
            InitialRandom=tick();
        end;
        randomizer=Random.new(InitialRandom);
    end;
    if not hasStarted then
        hasStarted=true;
        Generate(30);
    end;
end);
local outwardRetries=0;
local maxOutwardRetries=5;

function isObstructed(linkage:Attachment,previous:Model,newModelLinkage:Attachment,newModel:Model)
    local centerCFrame, size = newModel:GetBoundingBox();
    size = size * .95; --slightly smaller than the floor
    local offsetFromPivot = newModel:GetPivot():ToObjectSpace(centerCFrame);
    local PivotCFrame = linkage.WorldCFrame*newModelLinkage.WorldCFrame:ToObjectSpace(newModel:GetPivot());
    local centerBounds = PivotCFrame * offsetFromPivot;
    local params = OverlapParams.new();
    params.FilterType = Enum.RaycastFilterType.Exclude;
    params.FilterDescendantsInstances = {previous,newModel};
    local partsInBounds = workspace:GetPartBoundsInBox(centerBounds, size, params);
    return #partsInBounds > 0;
end;

function chooseLinkage(model)
    local floor=model:FindFirstChild("Build"):FindFirstChild("Floor");
    if not floor then return nil end;
    local linkage=floor:FindFirstChild("BackLinkage");
    if not linkage then
        local availableLinks={};
        for i,v in floor:GetChildren() do
            if v.Name:match("Linkage") then
                table.insert(availableLinks,v);
            end;
        end
        linkage=availableLinks[randomizer:NextInteger(1,#availableLinks)];
    end;
    if not linkage then
        warn("No linkage found for model: "..model.Name);
        return nil;
    end;
    return linkage;
end;

function placePiece(linkage:Attachment,previous:Model,pieces:{Instance},wasLastTurnLeft)
    randomizer=Random.new(InitialRandom+iteration);
    if #pieces==0 then return false,nil end;
    local randomIndex=randomizer:NextInteger(1,#pieces)
    local newModel:Model=pieces[randomIndex]:Clone();
    local CannotConnectTo=newModel:FindFirstChild("CannotConnectTo");
    local IterationsUntilFirstAppearence=newModel:FindFirstChild("IterationsUntilFirstAppearence") and newModel.IterationsUntilFirstAppearence.Value or 1;
    local modelMain=newModel:FindFirstChild("Build");
    local function retry(removeFromIndex:boolean)
        if removeFromIndex==nil then removeFromIndex=true; end;
        if removeFromIndex then
            table.remove(pieces,randomIndex);
        end;
        return placePiece(linkage,previous,pieces,wasLastTurnLeft);
    end;
    if modelMain then
        local floor=modelMain:FindFirstChild("Floor");
        if not floor then 
            return retry();
        end;
        local newModelLinkage:Attachment=chooseLinkage(newModel);
        if not newModelLinkage then
            return retry();
        end;
        if CannotConnectTo then
            CannotConnectTo=CannotConnectTo.Value;
            local Connections=string.split(CannotConnectTo,",");
            for i,v in Connections do
                if previous.Name==v then
                    return retry();
                end;
            end;
        end;
        if not wasLastTurnLeft[previous] then
            if newModel.Name:lower():find("right") then
                return retry();
            end;
            if newModel.Name:lower():find("left") then
                wasLastTurnLeft[previous]=true;
            end;
        else
            if newModel.Name:lower():find("left") then
                return retry();
            end;
            if newModel.Name:lower():find("right") then
                wasLastTurnLeft[previous]=false;
            end;
        end;
        if iteration%IterationsUntilFirstAppearence~=0 then
            return retry();
        end;
        if isObstructed(linkage,previous,newModelLinkage,newModel) then
            warn(newModel, "is obstructed trying to connect to", linkage, "from", previous)
            return retry();
        end
        if ((previous:GetPivot().Position-spawnPosition).Magnitude>(newModel:GetPivot().Position-spawnPosition).Magnitude) and outwardRetries<maxOutwardRetries then
            outwardRetries+=1;
            return retry(false);
        end;
        outwardRetries=0;
        newModel:PivotTo(linkage.WorldCFrame*newModelLinkage.WorldCFrame:ToObjectSpace(newModel:GetPivot()));
        return true,newModel,newModelLinkage;
    end;
end;

local recursionDepth=0;
local maxRecursionDepth=8;
local currentIterationPieces={};

function generateNext(previousPieces:{Model}):{Model}
    local pieces=script.AvailablePool:GetChildren();
    local newModels={};
    local willIncrement=false;
    if not previousPieces then
        previousPieces={workspace.Spawn};
    end;
    for i,previous in previousPieces do
        for i,linkage in pairs(previous:FindFirstChild("Build"):FindFirstChild("Floor"):GetChildren()) do
            if linkage:IsA("Attachment") and linkage.Name:match("Linkage") and linkage.Name~="BackLinkage" then
                local suc,new,link=placePiece(linkage,previous,pieces,currentIterationPieces);
                if suc then
                    willIncrement=true;
                    link.Name="BackLinkage";
                    table.insert(newModels,new);
                else
                    warn("Failed to generate next piece.")
                    willIncrement=false;
                end;
                task.wait();
            end;
        end;
    end;
    if willIncrement then
        iteration+=1;
    end;
    currentIterationPieces={};
    for i,v in pairs(newModels) do
        if currentIterationPieces[v]==nil then
            currentIterationPieces[v]=false; --was previous left?
        end;
    end;
    return newModels;
end;

local previousPieces=nil;
function Generate(count)
    --demo for now
    local RoomFolder=workspace:FindFirstChild("Pieces") or Instance.new("Folder",workspace);
    RoomFolder.Name="Pieces";
    for i=1,count do
        previousPieces=generateNext(previousPieces);
        for i,prevPiece in previousPieces do
            prevPiece.Parent=RoomFolder;
            local modelMain=prevPiece:FindFirstChild("Build");
            if modelMain then
                local generateNewTouchpart=modelMain:FindFirstChild("Floor");
                if generateNewTouchpart then
                    generateNewTouchpart.Touched:Once(function()
                        Generate(1); -- TO INFINITY AND BEYOND!
                    end);
                end;
            end;
        end;
    end;
end;