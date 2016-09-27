package com.alex;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AlexMain {

  public static void main(String args[]) {

    String fileName = "src/main/resources/mergesort.c";
    File file = new File(fileName);
    try {

      FileInputStream fis = new FileInputStream(file);

      ANTLRInputStream ais = new ANTLRInputStream(fis);

      CLexer lexer = new CLexer(ais);

      CommonTokenStream cts = new CommonTokenStream(lexer);

      CParser cparser = new CParser(cts);

      ParseTree tree = cparser.compilationUnit();

      ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
      MyCListener myListener = new MyCListener(cparser);
      walker.walk(myListener, tree); // initiate walk of tree with listener

      fis.close();

    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
