package pl.pollub.javatablereservations.interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NumberExpression implements Expression {

    @Override
    public double interpret(String text) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            return (Double) engine.eval(text);
        } catch (ScriptException exception) {
            throw new IllegalStateException("Given expression is invalid");
        }
    }
}
