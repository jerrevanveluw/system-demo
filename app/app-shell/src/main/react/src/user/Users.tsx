import React from 'react';
import { usePromiseState } from '../hooks/promise.hooks';
import { getUsers } from './user.service';
import { CircularProgress } from '@material-ui/core';
import { UserLi } from './UserLi';

export const Users = () => {
  const [data, loading] = usePromiseState(getUsers, []);

  return <>{loading ? <CircularProgress /> : data.map((it) => <UserLi user={it} />)}</>;
};
