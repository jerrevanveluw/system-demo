import { useEffect, useState } from 'react';

export function usePromiseState<T>(getPromise: () => Promise<T>, initialState: T): [T, boolean];

export function usePromiseState<T>(getPromise: () => Promise<T>, initialState: T | null): [T | null, boolean] {
  const [data, setData] = useState<(T | null) | T>(initialState);
  const loading = usePromiseEffect<T>(getPromise, setData);
  return [data, loading];
}

function usePromiseEffect<T>(fetch: () => Promise<T>, setData: (t: T) => void): boolean {
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    let isSubscribed = true;
    fetch().then((data: T) => {
      if (isSubscribed) {
        setData(data);
        setLoading(false);
      }
    });
    return () => {
      isSubscribed = false; // mitigates failing to load data in unmounted component
    };
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  return loading;
}
