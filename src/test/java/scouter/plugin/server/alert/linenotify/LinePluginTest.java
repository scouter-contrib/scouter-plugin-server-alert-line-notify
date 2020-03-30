package scouter.plugin.server.alert.linenotify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import scouter.lang.AlertLevel;
import scouter.lang.pack.AlertPack;
import scouter.server.Configure;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author Gun Lee (gunlee01@gmail.com) on 2016. 12. 20.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinePluginTest {
    public final static String notifyToken = "V62osjl4BgJR4kSEUGacJHx4aZ500R4NipNpnY2D1df";

    @Mock Configure conf;
    @InjectMocks
    LineNotifyPlugin plugin = new LineNotifyPlugin();

    @Test
    public void alert() throws Exception {
        when(conf.getValue("ext_plugin_line_notify_token")).thenReturn(notifyToken);
        when(conf.getBoolean(eq("ext_plugin_line_send_alert"), anyBoolean())).thenReturn(true);
        conf._trace = true;

        AlertPack ap = genAlertPack();
        plugin.alert(ap);

        Thread.sleep(10000);
    }

    private static AlertPack genAlertPack() {
        AlertPack ap = new AlertPack();

        ap.level = AlertLevel.WARN;
        ap.objHash = 100;
        ap.title = "Elapsed time exceed a threshold.";
        ap.message = "[100 agent] exceed a threshold";
        ap.time = System.currentTimeMillis();
        ap.objType = "someObjecttype";

        return ap;
    }

}
