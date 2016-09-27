package com.alex;

import org.antlr.v4.runtime.TokenStream;

public class MyCListener extends CBaseListener {

  CParser cParser;

  public MyCListener(CParser cParser) {
    this.cParser = cParser;
  }

  @Override
  public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
    /**
     * All of this is dependent on the rules in the grammar
     */
    System.out.println("Entering Function definition: { " );
    TokenStream tokens = cParser.getTokenStream();
    System.out.println("Declaration specifiers: ");
    System.out.println(ctx.declarationSpecifiers().getText());
  }

  @Override
  public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
    System.out.println(ctx.getText() + " }");
  }

}
