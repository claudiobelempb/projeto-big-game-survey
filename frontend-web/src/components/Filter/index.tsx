import { Link } from 'react-router-dom';

import './styles.css';

type FilterType = {
  label: string;
  href: string;
};

const Filter: React.FC<FilterType> = ({ label, href }) => {
  return (
    <div className='filters__container'>
      <Link to={href}>
        <button className='action__filters'>{label}</button>
      </Link>
    </div>
  );
};

export { Filter };
