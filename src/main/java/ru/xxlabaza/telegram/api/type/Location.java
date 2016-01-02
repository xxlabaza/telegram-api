/* 
 * The MIT License
 *
 * Copyright 2016 xxlabaza.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ru.xxlabaza.telegram.api.type;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * This object represents a point on the map.
 *
 * @author Artem Labazin
 *
 * @since Jul 1, 2015 | 12:41:32 AM
 *
 * @version 1.0.0
 */
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Location implements Serializable {

    private static final long serialVersionUID = -7785247862501831620L;

    /**
     * Longitude as defined by sender
     */
    private BigDecimal longitude;

    /**
     * Latitude as defined by sender
     */
    private BigDecimal latitude;
}
