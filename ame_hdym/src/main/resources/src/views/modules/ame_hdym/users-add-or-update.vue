<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="code">
      <el-input v-model="dataForm.code" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pwd">
      <el-input v-model="dataForm.pwd" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark">
      <el-input v-model="dataForm.remark" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r1">
      <el-input v-model="dataForm.r1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r2">
      <el-input v-model="dataForm.r2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r3">
      <el-input v-model="dataForm.r3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r4">
      <el-input v-model="dataForm.r4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r5">
      <el-input v-model="dataForm.r5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r6">
      <el-input v-model="dataForm.r6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r7">
      <el-input v-model="dataForm.r7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r8">
      <el-input v-model="dataForm.r8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r9">
      <el-input v-model="dataForm.r9" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r10">
      <el-input v-model="dataForm.r10" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r11">
      <el-input v-model="dataForm.r11" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r12">
      <el-input v-model="dataForm.r12" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r13">
      <el-input v-model="dataForm.r13" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r14">
      <el-input v-model="dataForm.r14" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r15">
      <el-input v-model="dataForm.r15" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r16">
      <el-input v-model="dataForm.r16" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r17">
      <el-input v-model="dataForm.r17" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r18">
      <el-input v-model="dataForm.r18" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r19">
      <el-input v-model="dataForm.r19" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="r20">
      <el-input v-model="dataForm.r20" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          code: '',
          pwd: '',
          name: '',
          remark: '',
          time: '',
          r1: '',
          r2: '',
          r3: '',
          r4: '',
          r5: '',
          r6: '',
          r7: '',
          r8: '',
          r9: '',
          r10: '',
          r11: '',
          r12: '',
          r13: '',
          r14: '',
          r15: '',
          r16: '',
          r17: '',
          r18: '',
          r19: '',
          r20: ''
        },
        dataRule: {
          code: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pwd: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r9: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r10: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r11: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r12: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r13: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r14: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r15: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r16: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r17: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r18: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r19: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          r20: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/users/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.users.code
                this.dataForm.pwd = data.users.pwd
                this.dataForm.name = data.users.name
                this.dataForm.remark = data.users.remark
                this.dataForm.time = data.users.time
                this.dataForm.r1 = data.users.r1
                this.dataForm.r2 = data.users.r2
                this.dataForm.r3 = data.users.r3
                this.dataForm.r4 = data.users.r4
                this.dataForm.r5 = data.users.r5
                this.dataForm.r6 = data.users.r6
                this.dataForm.r7 = data.users.r7
                this.dataForm.r8 = data.users.r8
                this.dataForm.r9 = data.users.r9
                this.dataForm.r10 = data.users.r10
                this.dataForm.r11 = data.users.r11
                this.dataForm.r12 = data.users.r12
                this.dataForm.r13 = data.users.r13
                this.dataForm.r14 = data.users.r14
                this.dataForm.r15 = data.users.r15
                this.dataForm.r16 = data.users.r16
                this.dataForm.r17 = data.users.r17
                this.dataForm.r18 = data.users.r18
                this.dataForm.r19 = data.users.r19
                this.dataForm.r20 = data.users.r20
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/users/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'pwd': this.dataForm.pwd,
                'name': this.dataForm.name,
                'remark': this.dataForm.remark,
                'time': this.dataForm.time,
                'r1': this.dataForm.r1,
                'r2': this.dataForm.r2,
                'r3': this.dataForm.r3,
                'r4': this.dataForm.r4,
                'r5': this.dataForm.r5,
                'r6': this.dataForm.r6,
                'r7': this.dataForm.r7,
                'r8': this.dataForm.r8,
                'r9': this.dataForm.r9,
                'r10': this.dataForm.r10,
                'r11': this.dataForm.r11,
                'r12': this.dataForm.r12,
                'r13': this.dataForm.r13,
                'r14': this.dataForm.r14,
                'r15': this.dataForm.r15,
                'r16': this.dataForm.r16,
                'r17': this.dataForm.r17,
                'r18': this.dataForm.r18,
                'r19': this.dataForm.r19,
                'r20': this.dataForm.r20
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
