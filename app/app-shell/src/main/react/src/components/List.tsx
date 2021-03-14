import React from 'react';
import { Users } from '../user/Users';
import { Todos } from '../todo/Todos';

export const List: React.FC = () => (
  <>
    <Users />
    <br />
    <Todos />
  </>
);
