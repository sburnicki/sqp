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

package io.sqp.backend;

import io.sqp.core.exceptions.SqpException;

import java.util.function.Consumer;

/**
 * @author Stefan Burnicki
 */
public class ResultHandler<T> {
    ErrorHandler _errorHandler;
    Consumer<T> _resultConsumer;

    public ResultHandler(ErrorHandler errorHandler, Consumer<T> resultConsumer) {
        _errorHandler = errorHandler;
        _resultConsumer = resultConsumer;
    }

    public void fail(SqpException e) {
        _errorHandler.handleError(e);
    }

    public void handle(T result) {
        _resultConsumer.accept(result);
    }
}
