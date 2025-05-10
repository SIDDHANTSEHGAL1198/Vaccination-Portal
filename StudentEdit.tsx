import { FC } from 'react';
import { Edit, SimpleForm, TextInput, BooleanInput } from 'react-admin';

export const StudentEdit: FC = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="className" />
            <TextInput source="dateOfBirth" />
            <BooleanInput source="vaccinated" />
        </SimpleForm>
    </Edit>
);
