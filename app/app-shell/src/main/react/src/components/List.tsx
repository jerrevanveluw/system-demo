import React from 'react';
import { useToDos, useUsers } from '../hooks/customHooks';
import { UserLi } from './UserLi';
import { TodoLi } from './TodoLi';

export const List: React.FC = () => (<>
  {useUsers().map(it => <UserLi user={it}/>)}
  <br/>
  {useToDos().map(it => <TodoLi todo={it}/>)}
</>);
