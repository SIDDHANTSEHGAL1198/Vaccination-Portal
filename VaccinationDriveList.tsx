import { List, Datagrid, TextField, EditButton } from 'react-admin';

export const VaccinationDriveList = () => (
    <List>
        <Datagrid>
            <TextField source="id" />
            <TextField source="vaccinationName" />
            <TextField source="date" />
            <TextField source="availableDoses" />
            <TextField source="applicableClasses" />
            <TextField source="isEditable" />
            <EditButton />
        </Datagrid>
    </List>
);
