import React from 'react';
import './App.css';
import { List } from './components/List';

const App: React.FC = () => {
  return (
    <div className="App">
      <header className="App-header">
        <List/>
      </header>
    </div>
  );
};

export default App;
