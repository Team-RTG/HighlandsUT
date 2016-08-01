package teamrtg.highlands.util.debug;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;

import net.minecraftforge.fml.common.FMLLog;

import org.apache.logging.log4j.Level;

public class Logger {

    public static void debug(String format, Object... data) {

        FMLLog.log(Level.INFO, "[Highlands-DEBUG] " + format, data);
    }

    public static void info(String format, Object... data) {

        FMLLog.log(Level.INFO, "[Highlands-INFO] " + format, data);
    }

    public static void warn(String format, Object... data) {

        FMLLog.log(Level.WARN, "[Highlands-WARN] " + format, data);
    }

    public static void error(String format, Object... data) {

        FMLLog.log(Level.ERROR, "[Highlands-ERROR] " + format, data);
    }

    public static void fatal(Throwable throwable, String message, Object... data) {

        FMLLog.log(Level.FATAL, "[Highlands-FATAL] " + message, data);
        Minecraft.getMinecraft().crashed(new CrashReport(message, throwable));
    }
}