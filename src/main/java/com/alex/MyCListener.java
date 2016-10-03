package com.alex;


import java.util.HashMap;
import java.util.Map;

public class MyCListener extends CBaseListener {

  private int functionDefinitionCount = 0;
  private Map<String, Integer> functionToCount;


  CParser cParser;

  public MyCListener(CParser cParser) {
    this.cParser = cParser;
    this.functionToCount = new HashMap<>();
  }

  @Override
  public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
    /**
     * All of this is dependent on the rules in the grammar
     */
    /*
    System.out.println("Entering Function definition: { " );
    TokenStream tokens = cParser.getTokenStream();
    System.out.println("Declaration specifiers: ");
    System.out.println(ctx.declarationSpecifiers().getText());
    */
    functionDefinitionCount++;
  }

  @Override
  public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
    //System.out.println(ctx.getText() + " }");
  }

  @Override
  public void enterArgumentExpressionList(CParser.ArgumentExpressionListContext ctx) {
    //System.out.println(ctx.getText());
    //System.out.println();
    //CParser.PostfixExpressionContext postFixCtx =  (CParser.PostfixExpressionContext)ctx.getParent();
    //System.out.println(postFixCtx.getText());
  }

  @Override
  public void enterPostfixArgumentExpressionList(CParser.PostfixArgumentExpressionListContext ctx) {
    String functionName = ctx.postfixExpression().getText();
    if (functionToCount.containsKey(functionName)) {
      int count = functionToCount.get(functionName);
      functionToCount.put(functionName, count + 1);
    }
    else {
      functionToCount.put(functionName, 1);
    }
  }

  @Override
  public void exitPostfixArgumentExpressionList(CParser.PostfixArgumentExpressionListContext ctx) {
    //System.out.println(ctx.getText());
  }

  public int getFunctionDefinitionCount() {
    return functionDefinitionCount;
  }

  public Map<String, Integer> getFunctionCallCounts() {
    return functionToCount;
  }

  public void printFunctionCallCounts() {
    System.out.println("Counts of function calls: ");
    for (Map.Entry<String, Integer> entry : functionToCount.entrySet()) {
      System.out.println("" + entry.getKey() + " : " + entry.getValue());
    }
  }

}
