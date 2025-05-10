import { Create, SimpleForm, TextInput, DateTimeInput } from 'react-admin';

export const VaccinationDriveCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="vaccinationName" />
            <DateTimeInput source="date" />
            <TextInput source="availableDoses" />
            <TextInput source="applicableClasses" />
        </SimpleForm>
    </Create>
);
