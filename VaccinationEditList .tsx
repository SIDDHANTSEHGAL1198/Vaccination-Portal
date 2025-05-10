import { Edit, SimpleForm, DateInput, NumberInput } from 'react-admin';

export const VaccinationDriveEdit = () => (
    <Edit>
        <SimpleForm>
            <DateInput source="driveDate" />
            <NumberInput source="availableDoses" />
        </SimpleForm>
    </Edit>
);