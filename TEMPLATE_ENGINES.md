# Template Engine Support

This project supports **five different template engines** for code generation, allowing developers to choose the engine that best fits their needs.

## Supported Template Engines

### 1. Apache Velocity (Default)
- **Version**: 2.4.1
- **Best For**: General-purpose templating with full Java integration
- **Syntax**: `$variable`, `#foreach`, `#if`, macros with `#macro`
- **Template Extension**: `.vtl`

### 2. StringTemplate 4 (ST4)
- **Version**: 4.3.4
- **Best For**: Code generation with strict separation of logic and presentation
- **Syntax**: `<variable>`, `<collection:{item | ...}>`, `<if(condition)>...<endif>`
- **Template Extension**: `.st`
- **Note**: Created by Terence Parr (ANTLR author), designed specifically for code generation

### 3. FreeMarker
- **Version**: 2.3.33
- **Best For**: Feature-rich templating with excellent documentation
- **Syntax**: `${variable}`, `<#list>`, `<#if>`, `<#macro>`
- **Template Extension**: `.ftl`
- **Note**: Very similar to Velocity but more powerful and actively maintained

### 4. JTE (Java Template Engine)
- **Version**: 3.1.14
- **Best For**: Modern, type-safe templates with compiled performance
- **Syntax**: `${variable}`, `@for`, `@if`, type-safe Java expressions
- **Template Extension**: `.jte`
- **Note**: Compiles templates to Java classes for maximum performance and type safety

### 5. Jinjava
- **Version**: 2.7.4
- **Best For**: Developers familiar with Python/Jinja2/Django templates
- **Syntax**: `{{ variable }}`, `{% for %}`, `{% if %}`, `{% macro %}`, filters with `|`
- **Template Extension**: `.jinja`
- **Note**: Java implementation of Jinja2 by HubSpot - brings Python's popular template syntax to Java

## Usage

### Using the Factory Pattern

```java
import org.pecheasoft.odigen.template.ITemplateService;
import org.pecheasoft.odigen.template.TemplateEngineType;
import org.pecheasoft.odigen.template.TemplateServiceFactory;

// Create a Velocity template service
ITemplateService velocityService = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.VELOCITY
);

// Create a StringTemplate 4 service
ITemplateService st4Service = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.STRING_TEMPLATE_4
);

// Create a FreeMarker service
ITemplateService freeMarkerService = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.FREEMARKER
);

// Create a JTE service
ITemplateService jteService = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.JTE
);

// Create a Jinjava service
ITemplateService jinjavaService = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.JINJAVA
);

// Use default engine (Velocity)
ITemplateService defaultService = TemplateServiceFactory.createDefaultTemplateService();
```

### Example: Evaluating Templates

```java
// Initialize the service
ITemplateService service = TemplateServiceFactory.createTemplateService(
    TemplateEngineType.VELOCITY  // or STRING_TEMPLATE_4, FREEMARKER, JTE, JINJAVA
);
service.initialize();

// Load templates
Collection<ITemplate> templates = Arrays.asList(template);
service.loadTemplates(templates);

// Evaluate with parameters
ITemplateParameter param = new TemplateEngineParameter("datastore", datastoreObject);
Collection<ITemplateParameter> parameters = Arrays.asList(param);
String result = service.evaluate(template, parameters);
```

## Template Syntax Comparison

### Velocity Syntax Example
```velocity
#set($xtDatastoreName="XT_" + $datastore.Name + "_V")

CREATE TABLE $xtDatastoreName (
#foreach($col in $datastore.Attributes)
    $col.Name $col.DDLDataType#if($col.IsMandatory) NOT NULL#end
#end
);

#macro(getDataType $col)
#if($col.isAnnotatedWith("PROPERTIES"))VARCHAR2_CHAR($col.Length)#else$col.DDLDataType#end
#end
```

### StringTemplate 4 Syntax Example
```stringtemplate
<xtDatastoreName>XT_<datastore.Name>_V</xtDatastoreName>

CREATE TABLE <xtDatastoreName> (
<datastore.Attributes:{col |    <col.Name> <col.DDLDataType> <if(col.IsMandatory)>NOT NULL<endif>
}>
);
```

### FreeMarker Syntax Example
```freemarker
<#assign xtDatastoreName = "XT_" + datastore.Name + "_V">

CREATE TABLE ${xtDatastoreName} (
<#list datastore.Attributes as col>
    ${col.Name} ${col.DDLDataType}<#if col.IsMandatory> NOT NULL</#if>
</#list>
);
```

### JTE Syntax Example
```jte
@param IASTObject datastore

@{var xtDatastoreName = "XT_" + datastore.getName() + "_V";}

CREATE TABLE ${xtDatastoreName} (
@for(var col : datastore.getAttributes())
    ${col.getName()} ${col.getDDLDataType()}@if(col.isMandatory()) NOT NULL@endif
@endfor
);
```

### Jinjava Syntax Example
```jinja
{% set xtDatastoreName = "XT_" + datastore.Name + "_V" %}

CREATE TABLE {{ xtDatastoreName }} (
{% for col in datastore.Attributes %}
    {{ "," if not loop.first else "    " }}{{ col.Name }} {{ col.DDLDataType }}{% if col.IsMandatory %} NOT NULL{% endif %}
{% endfor %}
);

-- Table: {{ xtDatastoreName | upper }}
-- Columns: {{ datastore.Attributes | length }}
```

## Key Differences

| Feature | Velocity | StringTemplate 4 | FreeMarker | JTE | Jinjava |
|---------|----------|------------------|------------|-----|---------|
| **Expressions** | `$var.method()` | `<var.method>` | `${var.method()}` | `${var.method()}` | `{{ var.method() }}` |
| **Iterations** | `#foreach($item in $list)...#end` | `<list:{item \| ...}>` | `<#list list as item>...</#list>` | `@for(var item : list)...@endfor` | `{% for item in list %}...{% endfor %}` |
| **Conditionals** | `#if($cond)...#else...#end` | `<if(cond)>...<else>...<endif>` | `<#if cond>...<#else>...</#if>` | `@if(cond)...@else...@endif` | `{% if cond %}...{% else %}...{% endif %}` |
| **Comments** | `## comment` or `#* *#` | `<! comment !>` | `<#-- comment -->` | `<%-- comment --%>` | `{# comment #}` |
| **Filters** | No | No | Limited | No | **Yes** (`\| upper`, `\| length`, etc.) |
| **Type Safety** | No | No | No | **Yes** | No |
| **Compilation** | Interpreted | Interpreted | Interpreted | **Compiled** | Interpreted |
| **Performance** | Good | Good | Good | **Excellent** | Good |
| **Logic** | Full Java | Restricted | Full | Full Java | Full |

## When to Use Which Engine

### Use Velocity When:
- You need full Java integration in templates
- You're familiar with Velocity syntax
- You need complex template logic
- You're maintaining existing Velocity templates
- **Best for**: General purpose, existing projects

### Use StringTemplate 4 When:
- Generating code (SQL, Java, etc.)
- You want strict separation of logic and presentation
- You're already using ANTLR in your project
- You prefer enforced template constraints
- **Best for**: Code generation, compiler projects

### Use FreeMarker When:
- You want powerful features with excellent documentation
- You need a Velocity alternative with more capabilities
- You want flexible macro systems
- You need good IDE support
- **Best for**: Complex templates, new projects, web applications

### Use JTE When:
- You need maximum performance
- Type safety is important
- You want compile-time error checking
- Working with Java models directly
- **Best for**: High-performance code generation, type-safe templates

### Use Jinjava When:
- You're familiar with Python/Jinja2/Django templates
- You want elegant, readable template syntax
- You need powerful filters and macros
- You're migrating from Python projects
- **Best for**: Teams with Python background, readable templates, filter-based transformations

## Dependencies

### Maven POM Configuration
```xml
<!-- Apache Velocity -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.4.1</version>
</dependency>

<!-- StringTemplate 4 -->
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>ST4</artifactId>
    <version>4.3.4</version>
</dependency>

<!-- FreeMarker -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.33</version>
</dependency>

<!-- JTE (Java Template Engine) -->
<dependency>
    <groupId>gg.jte</groupId>
    <artifactId>jte</artifactId>
    <version>3.1.14</version>
</dependency>

<!-- Jinjava (Java implementation of Jinja2) -->
<dependency>
    <groupId>com.hubspot.jinjava</groupId>
    <artifactId>jinjava</artifactId>
    <version>2.7.4</version>
</dependency>
```

## Project Structure

Example structure:
```
src/main/java/org/pecheasoft/odigen/template/
  ├── ITemplateService.java          (interface)
  ├── TemplateEngineType.java        (enum)
  ├── TemplateServiceFactory.java    (factory)
  ├── velocity/
  │   └── ApacheVelocityTemplateService.java
  ├── stringtemplate/
  │   └── StringTemplate4Service.java
  ├── freemarker/
  │   └── FreeMarkerTemplateService.java
  ├── jte/
  │   └── JteTemplateService.java
  └── jinjava/
      └── JinjavaTemplateService.java
```

## Resources

- **Velocity Documentation**: https://velocity.apache.org/engine/2.4/user-guide.html
- **StringTemplate 4 Documentation**: https://github.com/antlr/stringtemplate4/blob/master/doc/index.md
- **FreeMarker Documentation**: https://freemarker.apache.org/docs/
- **JTE Documentation**: https://jte.gg/
- **Jinjava Documentation**: https://github.com/HubSpot/jinjava
