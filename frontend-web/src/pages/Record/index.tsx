import { useEffect, useState } from 'react';
import axios from 'axios';

import { Header } from '../../components/Header';

import { TypeRecords } from 'types/TypeRecord';
import { FromatDate } from 'helpers/FormatDate';
import { Pagination } from '../../components/Pagination';
import { Filter } from '../../components/Filter';

import './styles.css';

const BASE_URL = 'http://localhost:8080';

const RecordPage: React.FC = () => {
  const [records, setRecords] = useState<TypeRecords>();
  const [activePage, setActivePage] = useState<number>(0);

  useEffect(() => {
    (async () => {
      try {
        const recors = await axios.get(
          `${BASE_URL}/records-date-page?linesPerPage=12&page=${activePage}`
        );
        setRecords(recors.data);
      } catch (error) {
        console.log(error, 'Errror');
      }
    })();
  }, [activePage]);

  const handlePageChange = (index: number) => {
    console.log(index);
    setActivePage(index);
  };

  return (
    <>
      <Header />

      <div className='records__container'>
        <Filter label='VER GRÁFICOS' href='/charts' />
        <table className='records__table' cellPadding={0} cellSpacing={0}>
          <thead>
            <tr>
              <th>INSTANTE</th>
              <th>NOME</th>
              <th>IDADE</th>
              <th>IDADE</th>
              <th>GÊNERO</th>
              <th>TITULO DO GAME</th>
            </tr>
          </thead>
          <tbody>
            {records?.content.map(record => (
              <tr key={record.id}>
                <td>{FromatDate(record.createdAt)}</td>
                <td>{record.name}</td>
                <td>{record.age}</td>
                <td className='text__coral'>{record.gamePlatform}</td>
                <td>{record.genreName}</td>
                <td className='text__blue'>{record.gameTitle}</td>
              </tr>
            ))}
          </tbody>
        </table>

        <Pagination
          activePage={activePage}
          totalPages={records?.totalPages}
          goToPage={handlePageChange}
        />
      </div>
    </>
  );
};

export default RecordPage;
