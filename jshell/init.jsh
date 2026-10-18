System.out.println("\u001B[36m==============================================\u001B[0m");
System.out.println("\u001B[36m        SQL Morph Interactive Shell           \u001B[0m");
System.out.println("\u001B[36m==============================================\u001B[0m");
System.out.println("Environment initialized. Type help() for commands.\n");

import java.io.*;
import java.math.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.prefs.*;
import java.util.regex.*;
import java.util.stream.*;

import org.pecheasoft.odigen.metadata.*;
import org.pecheasoft.odigen.project.*;
import org.pecheasoft.odigen.render.*;
import org.pecheasoft.odigen.repl.*;
import org.pecheasoft.odigen.sql.api.ast.*;
import org.pecheasoft.odigen.sql.api.ast.impl.*;
import org.pecheasoft.odigen.sql.api.transform.*;
import org.pecheasoft.odigen.sql.parse.*;
import org.pecheasoft.odigen.sql.parse.algebra.*;
import org.pecheasoft.odigen.sql.parse.formatter.*;
import org.pecheasoft.odigen.sql.util.*;
import org.pecheasoft.odigen.sql.util.annotation.*;
import org.pecheasoft.odigen.sql.util.graph.*;
import org.pecheasoft.odigen.template.freemaker.*;
import org.pecheasoft.odigen.template.jinjava.*;
import org.pecheasoft.odigen.template.jte.*;
import org.pecheasoft.odigen.template.pebble.*;
import org.pecheasoft.odigen.template.velocity.*;
import org.pecheasoft.odigen.project.Project;

Path root = Path.of("project");
Project project = new Project(root);
MetadataManager metadata = new MetadataManager(project);
CodeGeneratorService codegen = new CodeGeneratorService(project, metadata);

/set mode sqlmorph -command
/set format sqlmorph action "created" added-primary
/set format sqlmorph action "modified" modified-primary
/set format sqlmorph action "replaced" replaced-primary
/set format sqlmorph action "overwrote" overwrote-primary
/set format sqlmorph action "dropped" dropped-primary
/set format sqlmorph action "  update created" added-update
/set format sqlmorph action "  update modified" modified-update
/set format sqlmorph action "  update replaced" replaced-update
/set format sqlmorph action "  update overwrote" overwrote-update
/set format sqlmorph action "  update dropped" dropped-update
/set format sqlmorph display "{result}{pre}created scratch variable {name} : {type}{post}" expression-added,modified,replaced-primary
/set format sqlmorph display "{result}{pre}value of {name} : {type}{post}" varvalue-added,modified,replaced-primary
/set format sqlmorph display "{result}{pre}assigned to {name} : {type}{post}" assignment-primary
/set format sqlmorph display "{result}{pre}{action} variable {name} : {type}{resolve}{post}" varinit,vardecl
/set format sqlmorph display "{pre}{action} variable {name}{resolve}{post}" vardecl,varinit-notdefined
/set format sqlmorph display "{pre}{action} variable {name}{post}" dropped-vardecl,varinit,expression
/set format sqlmorph display "{pre}{action} {typeKind} {name}{resolve}{post}" class,interface,enum,annotation,record
/set format sqlmorph display "{pre}{action} method {name}({type}){resolve}{post}" method
/set format sqlmorph display "{pre}attempted to use {typeKind} {name}{resolve}{post}" used-class,interface,enum,annotation,record
/set format sqlmorph display "{pre}attempted to call method {name}({type}){resolve}{post}" used-method
/set format sqlmorph display "" added,modified,replaced,overwrote,dropped-update
/set format sqlmorph display "{pre}{action} variable {name}, reset to null{post}" replaced-vardecl,varinit-ok-update
/set format sqlmorph display "{pre}{action} variable {name}{resolve}{post}" replaced-vardecl,varinit-notdefined
/set format sqlmorph display "{result}" added,modified,replaced-expression,varvalue,assignment,varinit,vardecl-ok-primary
/set format sqlmorph err "%6$s"
/set format sqlmorph errorline "{post}{pre}    {err}"
/set format sqlmorph errorpost "%n"
/set format sqlmorph errorpre "|  "
/set format sqlmorph errors "%5$s"
/set format sqlmorph name "%1$s"
/set format sqlmorph post "%n"
/set format sqlmorph pre "|  "
/set format sqlmorph resolve "{until}{unrerr}" defined,notdefined-added,modified,replaced,used
/set format sqlmorph result "{name} ==> {value}{post}" added,modified,replaced-ok-primary
/set format sqlmorph type "%2$s"
/set format sqlmorph typeKind "class" class
/set format sqlmorph typeKind "interface" interface
/set format sqlmorph typeKind "enum" enum
/set format sqlmorph typeKind "annotation interface" annotation
/set format sqlmorph typeKind "record" record
/set format sqlmorph unrerr "{unresolved} is declared" unresolved1-error0
/set format sqlmorph unrerr "{unresolved} are declared" unresolved2-error0
/set format sqlmorph unrerr " this error is corrected: {errors}" unresolved0-error1
/set format sqlmorph unrerr "{unresolved} is declared and this error is corrected: {errors}" unresolved1-error1
/set format sqlmorph unrerr "{unresolved} are declared and this error is corrected: {errors}" unresolved2-error1
/set format sqlmorph unrerr " these errors are corrected: {errors}" unresolved0-error2
/set format sqlmorph unrerr "{unresolved} is declared and these errors are corrected: {errors}" unresolved1-error2
/set format sqlmorph unrerr "{unresolved} are declared and these errors are corrected: {errors}" unresolved2-error2
/set format sqlmorph unresolved "%4$s"
/set format sqlmorph until ", however, it cannot be instantiated or its methods invoked until" defined-class,record-primary
/set format sqlmorph until ", however, its methods cannot be invoked until" defined-interface-primary
/set format sqlmorph until ", however, it cannot be used until" defined-enum,annotation-primary
/set format sqlmorph until ", however, it cannot be invoked until" defined-method-primary
/set format sqlmorph until ", however, it cannot be referenced until" notdefined-primary
/set format sqlmorph until " which cannot be instantiated or its methods invoked until" defined-class,record-update
/set format sqlmorph until " whose methods cannot be invoked until" defined-interface-update
/set format sqlmorph until " which cannot be invoked until" defined-method-update
/set format sqlmorph until " which cannot be referenced until" notdefined-update
/set prompt sqlmorph "morph> " "......."