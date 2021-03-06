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

package io.sqp.backend.results;

import io.sqp.core.InformationResponseType;

/**
 * @author Stefan Burnicki
 */
// this is somehow a duplicate of InformationRequestResult, but decouples message logic from backend logic
public class InformationRequestResult {
    public final static InformationRequestResult UNKNOWN = new InformationRequestResult(InformationResponseType.Unknown, null);
    public final static InformationRequestResult DELEGATE = new InformationRequestResult(InformationResponseType.Unknown, null);
    private InformationResponseType _type;
    private Object _value;

    public InformationRequestResult(InformationResponseType type, Object value) {
        _type = type;
        _value = value;
    }

    public InformationResponseType getType() {
        return _type;
    }

    public Object getValue() {
        return _value;
    }
}
