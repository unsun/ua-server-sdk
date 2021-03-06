/*
 * digitalpetri OPC-UA SDK
 *
 * Copyright (C) 2015 Kevin Herron
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.digitalpetri.opcua.sdk.server.events;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.events.SystemStatusChangeEventType;
import com.digitalpetri.opcua.stack.core.types.builtin.ByteString;
import com.digitalpetri.opcua.stack.core.types.builtin.DateTime;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UShort;
import com.digitalpetri.opcua.stack.core.types.enumerated.ServerState;
import com.digitalpetri.opcua.stack.core.types.structured.TimeZoneDataType;

/**
 * A {@link SystemStatusChangeEvent} is an Event of {@link SystemStatusChangeEventType} that indicates a status change
 * in a system.
 * <p>
 * For example, if the status indicates an underlying system is not running, then a Client cannot expect any Events
 * from the underlying system. A Server can identify its own status changes using this EventType.
 */
public class SystemStatusChangeEvent extends SystemEvent implements SystemStatusChangeEventType {

    private final ServerState systemState;

    public SystemStatusChangeEvent(ByteString eventId,
                                   NodeId eventType,
                                   NodeId sourceNode,
                                   String sourceName,
                                   DateTime time,
                                   DateTime receiveTime,
                                   Optional<TimeZoneDataType> localTime,
                                   LocalizedText message,
                                   UShort severity,
                                   ServerState systemState) {

        super(eventId, eventType, sourceNode, sourceName, time, receiveTime, localTime, message, severity);

        this.systemState = systemState;
    }

    @Override
    public ServerState getSystemState() {
        return systemState;
    }

    public static class SystemStatusChangeEventBuilder extends BaseEventBuilder {

        private ServerState serverState;

        public SystemStatusChangeEventBuilder setServerState(ServerState serverState) {
            this.serverState = serverState;
            return this;
        }

        public SystemStatusChangeEvent build() {
            return new SystemStatusChangeEvent(
                    eventId,
                    eventType,
                    sourceNode,
                    sourceName,
                    time,
                    receiveTime,
                    localTime,
                    message,
                    severity,
                    serverState
            );
        }

    }

}
