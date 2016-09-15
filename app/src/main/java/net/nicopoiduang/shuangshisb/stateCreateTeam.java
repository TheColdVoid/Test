package net.nicopoiduang.shuangshisb;

import java.util.ArrayList;

/**
 * Created by The_Void on 2016/9/7.
 */
public class stateCreateTeam extends avalonState{
    @Override
    public void init() {
        if(game.round==1)
        game.setPlayerStatus("请等待队长组队");
        else game.setPlayerStatus(game.agreeCount+"同意"+game.disAgreeCount+"反对");
    }
    public stateCreateTeam(game game)
    {
        super(game);
        game.nextLeader();
        game.leader.isInCreateTeam=true;
        if(game.round==1)
        game.leader.status="请你组队";

    }
    @Override
    void handle() {
        if(game.isTeamAvailable() && player.isLeader)
        {
            game.team=(ArrayList<net.nicopoiduang.shuangshisb.player>) game.selection.clone();
            for (player i :
                    game.team) {
                i.isInTeam = true;
            }
            game.leader.isInCreateTeam=false;
            game.nowState=new stateVoteTeam(game);
        }
    }
}
