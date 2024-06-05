import React, { useEffect, useState } from 'react';
import axios from 'axios';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

const DataDisplay = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        // Fetch initial data
        axios.get('http://localhost:8080/api/data')
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the data!', error);
            });

        // Setup WebSocket connection
        const socket = new SockJS('http://localhost:8080/ws');
        const stompClient = Stomp.over(socket);

        stompClient.connect({}, frame => {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/data', message => {
                const newData = JSON.parse(message.body);
                setData(prevData => [...prevData, newData]);
            });
        });

        return () => {
            if (stompClient) {
                stompClient.disconnect();
            }
        };
    }, []);

    return (
        <div>
            <h1>Data from Backend</h1>
            <ul>
                {data.map((item) => (
                    <li key={item.id}>
                        <p>ID: {item.id}</p>
                        <p>Timestamp: {item.timestamp}</p>
                        <p>Title: {item.title}</p>
                        <p>Description: {item.description}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default DataDisplay;
