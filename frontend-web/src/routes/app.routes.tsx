import React from 'react';

import { useRoutes } from 'react-router-dom';

import Charts from '../pages/Charts';
import NotFoundPage from '../pages/404';
import HomePage from '../pages/Home';
import RecordPage from 'pages/Record';

const AppUseRoutes: React.FC = () => {
  return useRoutes([
    { path: '/', element: <HomePage /> },
    { path: '/records', element: <RecordPage /> },
    { path: '/charts', element: <Charts /> },
    {
      path: '*',
      element: <NotFoundPage />
    }
  ]);
};

export { AppUseRoutes };
