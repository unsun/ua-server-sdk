/*
 * Copyright 2014 Inductive Automation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.inductiveautomation.opcua.sdk.server.model;

import com.inductiveautomation.opcua.sdk.core.model.BaseDataVariableType;
import com.inductiveautomation.opcua.stack.core.types.builtin.unsigned.UInteger;
import com.inductiveautomation.opcua.stack.core.types.structured.ServerDiagnosticsSummaryDataType;

public interface ServerDiagnosticsSummaryType extends BaseDataVariableType<ServerDiagnosticsSummaryDataType> {

    UInteger getServerViewCount();
    UInteger getCurrentSessionCount();
    UInteger getCumulatedSessionCount();
    UInteger getSecurityRejectedSessionCount();
    UInteger getRejectedSessionCount();
    UInteger getSessionTimeoutCount();
    UInteger getSessionAbortCount();
    UInteger getPublishingIntervalCount();
    UInteger getCurrentSubscriptionCount();
    UInteger getCumulatedSubscriptionCount();
    UInteger getSecurityRejectedRequestsCount();
    UInteger getRejectedRequestsCount();

}