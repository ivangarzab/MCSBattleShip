package mcs.salazar.jesus.mcsbattleship;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ivan on 2/5/2018
 */
public class Session extends Model {

    private final static int BATTLEFIELD_SIZE = 10;
    private final static int BATTLESHIPS_PER_PLAYER = 6;

    private User mChallenger;
    private Battlefield mChallengerBattlefield;
    private User mChallengee;
    private Battlefield mChallengeeBattlefield;
    private User mNextTurn;
    private int mTotalTurns;
    private String mDateStarted;
    private String mDateFinished;

    public Session(User challenger, User challengee) {
        mChallenger = challenger;
        mChallengerBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mChallengee = challengee;
        mChallengeeBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mNextTurn = mChallengee;
        mTotalTurns = 0;
        // Get today's date
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        mDateStarted = df.format(c.getTime());
        mDateFinished = "";
    }
}
