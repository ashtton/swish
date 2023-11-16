package pw.swish.backend.statistic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
@AllArgsConstructor
public enum Statistic {

    TWO_PT("2Pt", "The number of 2 point shots made."),
    TWO_PT_A("2PtA", "The number of 2 point shots attempted."),


    THREE_PT("3Pt", "The number of 3 point shots made."),
    THREE_PT_A("3PtA", "The number of 3 point shots attempted."),

    FREE_T("FT", "The number of free throws made."),
    FREE_TA("FTA", "The number of free throws attempted."),

    LAYUP("Layup", "The number of layups made."),
    LAYUP_A("LayupA", "The number of layups attempted."),

    PAINT("Paint", "The number of points scored in the paint."),
    PAINT_A("PaintA", "The number of shots attempted in the paint."),

    OFF_R("OReb","The number of offensive rebounds"),
    DEF_R("DReb", "The number of defensive rebounds."),

    ASSIST("Ast", "The number of assists"),
    TURNOVER("TO", "The number of turnovers."),

    FORCE_TURN("Force TO", "The number of turnovers forced by defensive player."),
    DEFL("Dlfc", "The number of deflections by a defensive player or team"),
    DEFL_V("Dlfc Vic", "The number of times an offensive player has a pass deflected."),

    STEAL("Stl", "The number of steals by a defensive player."),
    BLOCK("Blk", "The number of blocks by a defensive player."),
    BLOCK_V("Blk Vic", "The number of times that an offensive player has a shot blocked."),

    CHARGE("Chrg", "The number of time a defensive player takes a charge."),
    FOUL("Foul", "The number of personal fouls committed."),
    FOULED("Fouled", "The number of times a player is fouled."),

    JUMP("Force Jmp", "The number of forced jump balls by a defensive player."),
    JUMP_V("Jmp Vic", "The number of times that an offensive player is forced into a jump ball."),

    DEF_STOP("Def Stop", "The number of possessions a team prevents the offense from scoring any points.", true)
    ;

    private final String abbreviation;
    private final String description;

    private boolean teamsOnly = false;
}
