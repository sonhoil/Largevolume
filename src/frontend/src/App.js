import React from 'react';
import DataDisplay from './components/DataDisplay';
import WebSocketComponent from './components/WebSocketComponent';

const App = () => (
    <div>
        <DataDisplay />
        <WebSocketComponent />
    </div>
);

export default App;
