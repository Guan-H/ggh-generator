<template>
    <!-- action -->
    <page-view title="新建查询页面">
        <template slot="action">
            <a-row>
                <a-button-group>
                    <a-button type="primary" @click="onAdd" icon="plus">新建查询页面</a-button>
                </a-button-group>
            </a-row>
        </template>
        <a-card>
            <a-row>
                <a-form :form="form" class="pick-100 form-input about">
                    <a-row>
                    </a-row>
                    <a-row>
                        <a-col :span="11">
                            <a-form-item label="编号">
                                <a-input v-model="queryParam.number"/>
                            </a-form-item>
                        </a-col>
                        <a-col :span="11">
                            <a-form-item label="申请人">
                                <a-input v-model="queryParam.proposer"/>
                            </a-form-item>
                        </a-col>
                    </a-row>
                    <a-row>
                        <a-col :span="11">
                            <a-form-item label="接待对象">
                                <a-input v-model="queryParam.receptiontarget"/>
                            </a-form-item>
                        </a-col>
                    </a-row>
                        <a-row>
                            <a-col :span="24" class="footer-button">
                                <a-form-item :wrapperCol="{ span: 23 }" style="text-align: center">
                                    <a-button type="primary" @click="onSearch">查询</a-button>
                                    <a-button @click="reset" style="margin-left: 20px">重置</a-button>
                                </a-form-item>
                            </a-col>
                        </a-row>
                </a-form>
            </a-row>
        </a-card>
    </page-view>
</template>

<script>
    import {PageView} from "@/layouts";
    import STable from "@/components/Table";
    import qs from "qs";

    export default {
        components: {STable, PageView},
        data() {
            return {
                form: this.$form.createForm(this),
                caseTypeId: this.$route.query.caseTypeId,
                queryParam: {
                    number: '',
                    proposer: '',
                    receptiontarget: '',
                },
            };
        },
        methods: {
            onAdd() {
                this.$router.push({path: "/tclientmeals/tclientmealsadd?caseTypeId=" + this.caseTypeId});
            },
            onSearch() {
                this.$refs.table.refresh();
            },
            reset() {
                this.queryParam = {
                    number: '',
                    proposer: '',
                    receptiontarget: '',
                }
                this.$refs.table.refresh();
            },
        },
        mounted() {
        },
    };
</script>

<style lang="scss" scoped>

</style>
