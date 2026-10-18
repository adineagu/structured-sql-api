package org.pecheasoft.odigen.project;

import java.nio.file.Path;

public record ProjectObjectId(
    ObjectType type,
    String qualifiedName,
    Path filePath
) {}

