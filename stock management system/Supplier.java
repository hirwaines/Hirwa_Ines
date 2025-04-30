// Supplier.java
import java.util.regex.Pattern;

public class Supplier {
    private String supplierId;
    private String companyName;
    private String contactPerson;
    private String phone;
    private String email;

    public Supplier(String supplierId, String companyName, String contactPerson, String phone, String email) {
        setSupplierId(supplierId);
        setCompanyName(companyName);
        setContactPerson(contactPerson);
        setPhone(phone);
        setEmail(email);
    }

    // Getters and setters with validation
    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) {
        if (supplierId != null && !supplierId.isEmpty()) {
            this.supplierId = supplierId;
        } else {
            throw new IllegalArgumentException("Supplier ID cannot be empty");
        }
    }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) {
        if (companyName != null && !companyName.isEmpty()) {
            this.companyName = companyName;
        } else {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
    }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) {
        if (contactPerson != null && !contactPerson.isEmpty()) {
            this.contactPerson = contactPerson;
        } else {
            throw new IllegalArgumentException("Contact person cannot be empty");
        }
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        if (phone != null && Pattern.matches("^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email != null && Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    @Override
    public String toString() {
        return String.format("Supplier ID: %s\nCompany: %s\nContact: %s\nPhone: %s\nEmail: %s",
                           supplierId, companyName, contactPerson, phone, email);
    }
}
