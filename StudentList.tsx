import { FC } from 'react';
import {
    List,
    Datagrid,
    TextField,
    BooleanField,
    EditButton,
    ExportButton,
    TopToolbar,
    Button,
    useNotify,
    useRefresh,
} from 'react-admin';
import UploadIcon from '@mui/icons-material/Upload';

const StudentList: FC = () => {
    const notify = useNotify();
    const refresh = useRefresh();

    const handleUpload = async (e: React.ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files?.[0];
        if (!file) return;

        const formData = new FormData();
        formData.append("file", file);

        try {
            await fetch("http://localhost:8086/students/upload", {
                method: "POST",
                body: formData,
                credentials: "include",
            });
            notify("CSV uploaded successfully", { type: "success" });
            refresh(); // Reload list
        } catch {
            notify("CSV upload failed", { type: "error" });
        }
    };

    const ListActions = () => (
        <TopToolbar>
            <ExportButton />
            <label htmlFor="upload-csv">
                <input
                    id="upload-csv"
                    type="file"
                    accept=".csv"
                    style={{ display: 'none' }}
                    onChange={handleUpload}
                />
                <Button component="span" label="Upload CSV">
                    <UploadIcon />
                </Button>
            </label>
        </TopToolbar>
    );

    return (
        <List actions={<ListActions />}>
            <Datagrid>
                <TextField source="id" />
                <TextField source="name" />
                <TextField source="className" />
                <TextField source="dateOfBirth" />
                <BooleanField source="vaccinated" />
                <EditButton />
            </Datagrid>
        </List>
    );
};

export default StudentList;
