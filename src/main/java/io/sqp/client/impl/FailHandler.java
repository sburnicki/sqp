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

package io.sqp.client.impl;

import io.sqp.core.ErrorType;
import io.sqp.core.ErrorAction;
import io.sqp.core.exceptions.SqpException;

import java.util.concurrent.CompletionException;
import java.util.function.Function;

/**
 * @author Stefan Burnicki
 */
public class FailHandler implements Function<Throwable, Void> {
    SqpConnectionImpl _connection;

    public FailHandler(SqpConnectionImpl connection) {
        _connection = connection;
    }

    @Override
    public Void apply(Throwable e) {
        if (e instanceof CompletionException) {
            e = e.getCause();
        }
        if (!(e instanceof SqpException)) {
            e = new SqpException(ErrorType.Unknown, e.getMessage(), ErrorAction.Recover, e);
        }
        _connection.handleError((SqpException) e);
        return null;
    }
}