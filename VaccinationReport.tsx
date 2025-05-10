import {
    List,
    Datagrid,
    TextField,
    BooleanField,
    Filter,
    TextInput,
    downloadCSV,
    TopToolbar,
    ExportButton,
    useListContext,
} from 'react-admin';
import jsonExport from 'jsonexport/dist';

const VaccinationFilter = (props: any) => (
    <Filter {...props}>
        <TextInput label="Vaccine Name" source="vaccineName" alwaysOn />
    </Filter>
);

const exporter = (records: any[]) => {
    jsonExport(records, (err, csv) => {
        if (err) {
            console.error(err);
        } else {
            downloadCSV(csv, 'vaccination_report');
        }
    });
};

const ReportActions = () => {
    const { exporter: contextExporter } = useListContext();
    return (
        <TopToolbar>
            <ExportButton exporter={contextExporter || undefined} />
        </TopToolbar>
    );
};

export const VaccinationReport = () => (
    <List
        filters={<VaccinationFilter />}
        exporter={exporter}
        actions={<ReportActions />}
        title="Vaccination Report"
        perPage={10}
    >
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="className" />
            <TextField source="vaccineName" />
            <TextField source="dateOfVaccination" />
            <BooleanField source="vaccinated" />
        </Datagrid>
    </List>
);
