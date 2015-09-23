/*
 * Copyright 2015 by Rothmeyer Consulting (http://www.rothmeyer.com/)
 * Author: Stefan Burnicki <stefan.burnicki@burnicki.net>
 *
 * This file is part of SQP.
 *
 * SQP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * SQP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with SQP.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.sqp.schemamatcher.fieldmatchers;

import com.fasterxml.jackson.databind.JsonNode;
import io.sqp.schemamatcher.NumberUtils;

/**
 * @author Stefan Burnicki
 */
public class MultipleOfMatcher extends NumberFieldMatcher {

    public MultipleOfMatcher(String fieldName, JsonNode schema) {
        super(fieldName, schema);
    }

    @Override
    protected boolean isValid(Double value) {
        return super.isValid(value) && value > 0;
    }

    @Override
    protected boolean otherDoubleIsLessRestrictive(Double fieldValue, Double otherValue) {
        return NumberUtils.roughlyEqual(fieldValue, otherValue) ||
               checkIsMultipleOf(otherValue, fieldValue);
    }

    private static boolean checkIsMultipleOf(double multiple, double base) {
        while (multiple >= base) {
            multiple -= base;
        }
        return NumberUtils.roughlyEqual(multiple, 0.0);
    }
}
