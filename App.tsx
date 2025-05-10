import React from 'react';
import { Admin, Resource } from 'react-admin';
import authProvider from './Login/authProvider';
import MyLoginPage from './Login/MyLoginPage';
import dataProvider from './dataProvider';
import { StudentEdit } from './Students/StudentEdit';
import StudentList from './Students/StudentList';
import { StudentCreate } from './Students/StudentCreate';
import Dashboard from './Dashboard/Dashboard';
import { VaccinationReport } from './Report/VaccinationReport';
import { VaccinationDriveCreate } from './Drives/VaccinationDriveCreate';
import { VaccinationDriveList } from './Drives/VaccinationDriveList';
import { VaccinationDriveEdit } from './Drives/VaccinationEditList ';

const App: React.FC = () => (
    <Admin
        dashboard={Dashboard}
        authProvider={authProvider}
        loginPage={MyLoginPage}
        dataProvider={dataProvider}
        
    >
        <Resource
            name="students"
            list={StudentList}
            edit={StudentEdit}
            create={StudentCreate}
        />

<Resource name="students/report" list={VaccinationReport} />
<Resource
    name="drives"
    list={VaccinationDriveList}
    edit={VaccinationDriveEdit}
    create={VaccinationDriveCreate}
/>
    </Admin>
);

<Resource
    name="drives"
    list={VaccinationDriveList}
    edit={VaccinationDriveEdit}
    create={VaccinationDriveCreate}
/>

export default App;
