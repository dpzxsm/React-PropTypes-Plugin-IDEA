package com.suming.plugin.utils;

import com.intellij.codeInsight.editorActions.SelectWordUtil;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class SelectWordUtilCompat {

    private SelectWordUtilCompat() {
    }

    public static final SelectWordUtil.CharCondition JAVASCRIPT_IDENTIFIER_PART_CONDITION = var1 -> var1 != ' ';


    public static void addWordOrLexemeSelection(boolean camel,
                                                @NotNull Editor editor,
                                                int cursorOffset,
                                                @NotNull List<TextRange> ranges,
                                                @NotNull SelectWordUtil.CharCondition isWordPartCondition) {
        if (IdeaCompat.BUILD_NUMBER >= IdeaCompat.Version.IDEA2016_2) {
            SelectWordUtil.addWordOrLexemeSelection(camel, editor, cursorOffset, ranges, isWordPartCondition);
        } else {
            CharSequence editorText = editor.getDocument().getImmutableCharSequence();
            SelectWordUtil.addWordSelection(camel, editorText, cursorOffset, ranges, isWordPartCondition);
        }

    }

}
