package com.alex;

public class MyCVisitor extends CBaseVisitor<Integer> {

  @Override
  public Integer visitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
    System.out.println("Visiting Function Definition ");
    return visitChildren(ctx);
  }
}
