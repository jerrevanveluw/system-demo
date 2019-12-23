import React from 'react';
import { useToDos, useUsers } from '../hooks/customHooks';

export const List: React.FC = () => {

  const users = useUsers();
  const toDos = useToDos();

  return <div>
    {users.map(it => (<div key={it.name}>{it.age}</div>))}
    {toDos.map(it => (<div key={it.name}>{it.due}</div>))}
  </div>;
};
