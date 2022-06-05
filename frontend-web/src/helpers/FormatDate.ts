import moment from 'moment';

export const FromatDate = (date: string) => {
  return moment(date).format('DD/MM/YYYY HH:mm');
};
