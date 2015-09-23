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

package io.sqp.client.exceptions;

import io.sqp.core.ErrorType;
import io.sqp.core.ErrorAction;
import io.sqp.core.exceptions.SqpException;

/**
 * @author Stefan Burnicki
 */
public class ConnectionException extends SqpException {
    public ConnectionException(String s, Throwable throwable) {
        super(ErrorType.ConnectingFailed, s, ErrorAction.Abort, throwable);
    }

    public ConnectionException(String s) {
        this(s, null);
    }
}
