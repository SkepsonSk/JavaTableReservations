package pl.pollub.javatablereservations.logger;


import org.slf4j.Logger;
import org.slf4j.Marker;

public class LoggerDecorator implements Logger {

    private final Logger loggerBase;

    public LoggerDecorator(Logger loggerBase) {
        this.loggerBase = loggerBase;
    }

    @Override
    public String getName() {
        return this.loggerBase.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.loggerBase.isTraceEnabled();
    }

    @Override
    public void trace(String s) {
        this.loggerBase.trace(s);
    }

    @Override
    public void trace(String s, Object o) {
        this.loggerBase.trace(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        this.loggerBase.trace(s, o, o1);
    }

    @Override
    public void trace(String s, Object... objects) {
        this.loggerBase.trace(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        this.loggerBase.trace(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return this.loggerBase.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String s) {
        this.loggerBase.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        this.loggerBase.trace(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        this.loggerBase.trace(marker, s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        this.loggerBase.trace(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        this.loggerBase.trace(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.loggerBase.isDebugEnabled();
    }

    @Override
    public void debug(String s) {
        this.loggerBase.debug(s);
    }

    @Override
    public void debug(String s, Object o) {
        this.loggerBase.debug(s, o);
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        this.loggerBase.debug(s, o, o1);
    }

    @Override
    public void debug(String s, Object... objects) {
        this.loggerBase.debug(s, objects);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        this.loggerBase.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return this.loggerBase.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {
        this.loggerBase.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        this.loggerBase.debug(marker, s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        this.loggerBase.debug(marker, s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        this.loggerBase.debug(marker, s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        this.loggerBase.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.loggerBase.isInfoEnabled();
    }

    @Override
    public void info(String s) {
        this.loggerBase.info(s);
    }

    @Override
    public void info(String s, Object o) {
        this.loggerBase.info(s, o);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        this.loggerBase.info(s, o, o1);
    }

    @Override
    public void info(String s, Object... objects) {
        this.loggerBase.info(s, objects);
    }

    @Override
    public void info(String s, Throwable throwable) {
        this.loggerBase.info(s, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return this.loggerBase.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {
        this.loggerBase.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        this.loggerBase.info(marker, s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        this.loggerBase.info(marker, s, o, o1);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        this.loggerBase.info(marker, s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        this.loggerBase.info(marker, s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.loggerBase.isWarnEnabled();
    }

    @Override
    public void warn(String s) {
        this.loggerBase.warn(s);
    }

    @Override
    public void warn(String s, Object o) {
        this.loggerBase.warn(s, o);
    }

    @Override
    public void warn(String s, Object... objects) {
        this.loggerBase.warn(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        this.loggerBase.warn(s, o, o1);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        this.loggerBase.warn(s, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return this.loggerBase.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {
        this.loggerBase.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        this.loggerBase.warn(marker, s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        this.loggerBase.warn(marker, s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        this.loggerBase.warn(marker, s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        this.loggerBase.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return this.loggerBase.isErrorEnabled();
    }

    @Override
    public void error(String s) {
        this.loggerBase.error(s);
    }

    @Override
    public void error(String s, Object o) {
        this.loggerBase.error(s, o);
    }

    @Override
    public void error(String s, Object o, Object o1) {
        this.loggerBase.error(s, o, o1);
    }

    @Override
    public void error(String s, Object... objects) {
        this.loggerBase.error(s, objects);
    }

    @Override
    public void error(String s, Throwable throwable) {
        this.loggerBase.error(s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return this.loggerBase.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {
        this.loggerBase.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        this.loggerBase.error(marker, s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        this.loggerBase.error(marker, s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        this.loggerBase.error(marker, s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        this.loggerBase.error(marker, s, throwable);
    }
}
