import React from 'react';
import { usePromiseState } from '../hooks/promise.hooks';
import { CircularProgress } from '@material-ui/core';
import { getTodos } from './todo.service';
import { TodoLi } from './TodoLi';

export const Todos = () => {
  const [data, loading] = usePromiseState(getTodos, []);

  return <>{loading ? <CircularProgress /> : data.map((it) => <TodoLi todo={it} />)}</>;
};
