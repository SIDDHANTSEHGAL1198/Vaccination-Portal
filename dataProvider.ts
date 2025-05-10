import simpleRestProvider from 'ra-data-simple-rest';
import { fetchUtils } from 'react-admin';

const httpClient = (url: string, options: fetchUtils.Options = {}) => {
    options.headers = new Headers(options.headers || { Accept: 'application/json' });
    options.credentials = 'include'; 
    return fetchUtils.fetchJson(url, options);
};

const dataProvider = simpleRestProvider('http://localhost:8086', httpClient);
export default dataProvider;
