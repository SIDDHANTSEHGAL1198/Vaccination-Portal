import { FC } from 'react';
import { Create, SimpleForm, TextInput, BooleanInput } from 'react-admin';

export const StudentCreate: FC = () => (
    <Create>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="className" />
            <TextInput source="dateOfBirth" />
            <BooleanInput source="vaccinated" />
        </SimpleForm>
    </Create>
);
