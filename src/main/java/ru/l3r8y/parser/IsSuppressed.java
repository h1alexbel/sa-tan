/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2023. Ivanchuck Ivan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ru.l3r8y.parser;

import java.util.List;
import lombok.SneakyThrows;
import org.cactoos.Scalar;

/**
 * Is check suppressed?
 *
 * @since 0.2.6
 */
public final class IsSuppressed implements Scalar<Boolean> {

    /**
     * Suppression prefix.
     */
    private static final String PREFIX = "OOP";

    /**
     * Suppressions.
     */
    private final Scalar<List<String>> suppressions;

    /**
     * Check to suppress.
     */
    private final String check;

    /**
     * Ctor.
     * @param spprs Suppressions
     * @param chk Check to suppress
     */
    public IsSuppressed(
        final Scalar<List<String>> spprs,
        final String chk
    ) {
        this.suppressions = spprs;
        this.check = chk;
    }

    @Override
    @SneakyThrows
    public Boolean value() {
        return this.suppressions.value().contains(
            String.format(
                "%s.%s",
                IsSuppressed.PREFIX,
                this.check
            )
        );
    }
}
