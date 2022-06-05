import React from 'react';

import './styles.css';

type PaginationProps = {
  totalPages?: number;
  goToPage: Function;
  activePage: number;
};

const Pagination: React.FC<PaginationProps> = ({
  totalPages = 0,
  goToPage,
  activePage
}) => {
  const paginationItems = Array.from(Array(totalPages).keys());

  return (
    <div className='pagination__container'>
      {paginationItems.map(page => (
        <button
          key={page}
          onClick={() => goToPage(page)}
          className={`pagination__item ${
            activePage === page ? 'active' : 'inactive'
          }`}
        >
          {page + 1}
        </button>
      ))}
    </div>
  );
};

export { Pagination };
