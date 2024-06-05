import React, { useEffect, useState } from 'react';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

const WebSocketComponent = () => {
    const [messages, setMessages] = useState([]);

    useEffect(() => {
        const socket = new SockJS('http://localhost:8080/ws');
        const stompClient = Stomp.over(socket);

        stompClient.connect({}, (frame) => {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/data', (messageOutput) => {
                setMessages(prevMessages => [...prevMessages, JSON.parse(messageOutput.body)]);
            });
        });

        return () => {
            stompClient.disconnect();
        };
    }, []);

    return (
        <div>
            <h1>WebSocket Messages</h1>
            <ul>
                {messages.map((message, index) => (
                    <li key={index}>{message.content}</li>
                ))}
            </ul>
        </div>
    );
};

export default WebSocketComponent;
