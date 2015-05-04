package chapter4.businesslogic;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.logging.Logger;

import static java.util.Calendar.*;

class BannerAdChooser {
    private static final Logger log =
            Logger.getLogger(BannerAdChooser.class.getName());
    private final BannerDao bannerDao = new BannerDao();

    public Banner getAd(User user, Page page) {
        if (user.getId() == 23759) {
            // This user demands not to be shown any ads.
            // See support ticket #4839
            return null;
        }

        if (page.getId().equals("profile")) {
            // Don't show ads on profile page
            return null;
        }

        if (page.getId().equals("top") &&
            Calendar.getInstance().get(DAY_OF_WEEK) == WEDNESDAY) {
            // No ads on top page on Wednesdays
            return null;
        }

        if (user.getId() % 5 == 0) {
            // A/B test - show banner 123 to these users
            return bannerDao.findById(123);
        }

        Banner banner = bannerDao.chooseRandomBanner();

        if (banner.getClientId() == 393) {
            if (user.getId() == 36645) {
                // Bad blood between this client and this user!
                // Don't show the ad.
                return null;
            }
        }

        // ... lots more checks and conditions ...

        return banner;
    }

}

class Banner {
    public int getClientId() {
        return 1;
    }
}

class BannerDao {
    public Banner findById(int id) {
        return null;
    }
    public Banner chooseRandomBanner() {
        return null;
    }
}

class Page {
    public String getId() {
        return "foo";
    }

}
class User {
    public int getId() {
        return 1;
    }
}